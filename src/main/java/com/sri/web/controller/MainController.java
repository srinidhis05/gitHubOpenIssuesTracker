package com.sri.web.controller;

import com.sri.DTO.IssueResponseDTO;
import com.sri.DTO.Result;
import com.sri.api.GitHubAPIService;
import com.sri.api.ResultGenerator;
import com.sri.form.model.URLModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    GitHubAPIService gitHubAPIService;

	@Autowired
	ResultGenerator resultGenerator;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage(ModelMap model) {
		URLModel urlModel = new URLModel();
		model.addAttribute("URL",urlModel);
		return "index";
	}

	@RequestMapping(value = "/getResults",method = RequestMethod.POST)
	public String urlSubmit(@ModelAttribute("URL") URLModel URL,Model model){
		try {
			//Check if the URl entered is proper
			if(gitHubAPIService.validateURL(URL.getURLLink())==null)
				return "invalidURL";
			//Check if the repo is accessible(Public)
			if(!gitHubAPIService.checkRepoAvailable()) {
				return "invalidRepo";
			}
			//All checks passed get the result
			    model.addAttribute("repoURL",gitHubAPIService.getRepoURL());
				model.addAttribute("totalIssues",gitHubAPIService.getRepo().getOpen_issues_count());
				Result result=resultGenerator.getIssuesBasedOnTime(gitHubAPIService.getOpenIssues());
				model.addAttribute("dayIssuesCount",result.getDayIssuesCount());
				model.addAttribute("weekIssuesCount",result.getWeekIssuesCount());
				model.addAttribute("longtermIssuesCount",result.getLongtermIssuesCount());
				return "result";
		}
		//Handling for rate limit error
		catch (Exception e) {
			return "rateLimitError";
		}
	}


}