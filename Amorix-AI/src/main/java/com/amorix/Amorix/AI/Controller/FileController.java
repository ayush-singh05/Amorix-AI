package com.amorix.Amorix.AI.Controller;

import com.amorix.Amorix.AI.Dto.File.Response.FileContentResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.FileNodeResponseDto;
import com.amorix.Amorix.AI.Service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/projects/{projectId}/files")
public class FileController {
    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNodeResponseDto>> getFileTree(@PathVariable Long projectId) {
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileTree(projectId, userId));
    }

    @GetMapping("/{*path}") // /src/hooks/get-user-hook.jsx
    public ResponseEntity<FileContentResponseDto> getFile(
            @PathVariable Long projectId,
            @PathVariable String path
    ) {
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileContent(projectId, path, userId));
    }
}
