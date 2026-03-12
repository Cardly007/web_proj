package com.blogger.blogger_box_backend.dto;

import java.util.UUID;

public record PostRequest(String tittle, String content, UUID categoryid) {
}
