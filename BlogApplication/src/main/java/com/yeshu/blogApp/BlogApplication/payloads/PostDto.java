package com.yeshu.blogApp.BlogApplication.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    @NotBlank
    @Size(min = 4,max = 25)
    private String title;
    @NotBlank
    @Size(min = 20,max = 25000)
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;


}
