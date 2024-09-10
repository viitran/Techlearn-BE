package com.techzen.techlearn.controller;

import com.techzen.techlearn.dto.request.ReviewConfigRequestDTO;
import com.techzen.techlearn.dto.response.ResponseData;
import com.techzen.techlearn.enums.ErrorCode;
import com.techzen.techlearn.service.ReviewConfigService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/admin/review-config")
public class ReviewRequestController {

    ReviewConfigService reviewConfigService;

    @GetMapping
    public ResponseData<?> getConfig() {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .result(reviewConfigService.getLatestConfig())
                .build();
    }

    @PostMapping
    public ResponseData<?> saveConfig(@RequestBody @Valid ReviewConfigRequestDTO config) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.ADD_SUCCESSFUL.getCode())
                .message(ErrorCode.ADD_SUCCESSFUL.getMessage())
                .result(reviewConfigService.saveConfig(config))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseData<?> updateConfig(@PathVariable Long id,
                                           @RequestBody @Valid ReviewConfigRequestDTO config) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.UPDATE_SUCCESSFUL.getCode())
                .message(ErrorCode.UPDATE_SUCCESSFUL.getMessage())
                .result(reviewConfigService.updateConfig(id, config))
                .build();
    }
}
