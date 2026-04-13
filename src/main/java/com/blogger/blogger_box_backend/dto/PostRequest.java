package com.blogger.blogger_box_backend.dto;

import java.util.UUID;

public record PostRequest(String title, String content, UUID categoryId) {
}
