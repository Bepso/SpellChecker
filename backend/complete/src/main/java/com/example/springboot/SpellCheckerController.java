package com.example.springboot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Info;
import com.example.springboot.model.Issue;
import com.example.springboot.model.Match;
import com.example.springboot.model.SpellCheck;

@RestController
public class SpellCheckerController {

	private static final String CROSS_ORIGIN_ORIGIN = "http://localhost:3000";
	private JLanguageTool langTool = new JLanguageTool(new AmericanEnglish());

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@PostMapping(path = "/message", consumes = "text/plain")
	@CrossOrigin(origins = CROSS_ORIGIN_ORIGIN)
	@ResponseBody
	public ResponseEntity<SpellCheck> postMessage(@RequestBody String message) {
		if (message == null || message.trim().isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		try {
			List<Issue> issues = getIssues(message, langTool);
			return new ResponseEntity<>(
				new SpellCheck(
					new Info(message),
					issues
				)
			,HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private List<Issue> getIssues(String message, JLanguageTool langTool) throws IOException {
		List<Issue> issues = new ArrayList<Issue>();
		List<RuleMatch> matches = langTool.check(message);
		for (RuleMatch match : matches) {
			issues.add(new Issue(
				match.getRule().getCategory().getName(),
				new Match(
					message.substring(match.getFromPos(), match.getToPos()),
					match.getFromPos(),
					match.getToPos(),
					match.getSuggestedReplacements()
				)
			));
		}
		return issues;
	}

}
