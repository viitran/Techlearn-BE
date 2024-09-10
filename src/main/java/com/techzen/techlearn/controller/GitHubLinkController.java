package com.techzen.techlearn.controller;

import com.techzen.techlearn.dto.request.GitHubLinkRequestDTO;
import com.techzen.techlearn.dto.response.ResponseData;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.service.GitHubLinkService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/githublinks")
public class GitHubLinkController {

    GitHubLinkService gitHubLinkService;

    @GetMapping
    public ResponseData<?> getAllGitHubLink(@RequestParam(required = false, defaultValue = "1") int page,
                                        @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result(gitHubLinkService.getAllGitHubLink(page, pageSize))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseData<?> getGitHubLinkById(@PathVariable Long id) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result(gitHubLinkService.getGitHubLinkById(id))
                .build();
    }

    @PostMapping
    public ResponseData<?> addGitHubLink(@RequestBody @Valid GitHubLinkRequestDTO request) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.ADD_SUCCESSFUL.getCode())
                .message(ErrorCode.ADD_SUCCESSFUL.getMessage())
                .result(gitHubLinkService.addGitHubLink(request))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseData<?> updateGitHubLink(@PathVariable Long id, @RequestBody GitHubLinkRequestDTO request) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.UPDATE_SUCCESSFUL.getCode())
                .message(ErrorCode.UPDATE_SUCCESSFUL.getMessage())
                .result(gitHubLinkService.updateGitHubLink(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseData<?> deleteGitHubLink(@PathVariable Long id) {
        gitHubLinkService.deleteGitHubLink(id);
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.DELETE_SUCCESSFUL.getCode())
                .message(ErrorCode.DELETE_SUCCESSFUL.getMessage())
                .message("Delete githublink success")
                .build();
    }
}
