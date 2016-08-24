package com.sri.api;

import com.google.gson.reflect.TypeToken;
import com.sri.DTO.IssueResponseDTO;
import com.sri.DTO.RepositoryDTO;
import com.sri.DTO.Result;
import com.sri.utilities.APIUtility;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * Created by srinidhis on 17/08/16.
 */
@Configuration
public class GitHubAPIService {

    private String repoURL;

    private RepositoryDTO repo= new RepositoryDTO();


    public String getRepoURL() {
        return repoURL;
    }

    public void setRepoURL(String repoURL) {
        this.repoURL = repoURL;
    }

    public RepositoryDTO getRepo() {
        return repo;
    }

    public void setRepo(RepositoryDTO repo) {
        this.repo = repo;
    }

    //Checks for the availability of repo and also rate limit
    public boolean checkRepoAvailable() throws Exception {
        URL url=new URL(URLMapper.REPO.getFullURLPath(repoURL));
        HttpURLConnection conn= APIUtility.sendGetRequest(url);
        //Success case get the no of issues
        if(conn.getResponseCode() == 200) {
            String response=APIUtility.getResponseAsString(conn.getInputStream());
            repo = (RepositoryDTO) APIUtility.convertJsonToDTO(response, new TypeToken<RepositoryDTO>() {}.getType());
            return true;
        }
        //Handling rate limit error for the application
        else if(conn.getResponseCode() == 403){
           throw new Exception();
        }
        //Failing case where the index is not there
        return false;
    }

    //Check if the repo has issues
    public boolean repoHasIssue(){
        return repo.hasIssues();
    }

    //function to get open issues
    public List<IssueResponseDTO> getOpenIssues() throws IOException {
        //The total pages is calculated for pagination
        int totalPages=(repo.getOpen_issues_count()/100)+1;
        String urlPath = URLMapper.ISSUES.getFullURLPath(repoURL);
        List<IssueResponseDTO> issues = new ArrayList<IssueResponseDTO>();
        for(int i=1;i<=totalPages;i++) {
            //The lists per page is consired as 100 to reduce the no of calls made
            String urlPathPage= urlPath + "?page=" + i + "&per_page=100";
            URL url = new URL(urlPathPage);
            HttpURLConnection conn= APIUtility.sendGetRequest(url);
            String response=APIUtility.getResponseAsString(conn.getInputStream());
            Type type = new TypeToken<ArrayList<IssueResponseDTO>>() {}.getType();
            issues.addAll((List<IssueResponseDTO>) APIUtility.convertJsonToDTO(response, type));
        }
        return issues;
    }

//Validates the URL by user
    public String validateURL(String URL) {
        String reposURL=null;
        if(Pattern.matches("^https:\\/\\/github.com\\/[a-zA-Z0-9]*\\/[a-zA-Z0-9]*$",URL))
        {
            String[] splitURL=URL.split("/");
            reposURL=splitURL[3]+"/"+splitURL[4];
        }
        repoURL=reposURL;
        return reposURL;
    }

    public static void main(String[] args) throws Exception {
        GitHubAPIService gitHubAPIService = new GitHubAPIService();
//        System.out.println(gitHubAPIService.checkRepoAvailable("Shippable/support"));
//        gitHubAPIService.getOpenIssues();
//        ResultGenerator resultGenerator=new ResultGenerator();
//        Result result=resultGenerator.getIssuesBasedOnTime(gitHubAPIService.getOpenIssues());
        gitHubAPIService.validateURL("https://github.com/Shippable/support");
    }



}
