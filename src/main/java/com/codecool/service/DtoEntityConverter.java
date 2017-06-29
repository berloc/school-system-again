package com.codecool.service;


import com.codecool.dto.StudentDto;
import com.codecool.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoEntityConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Student convertToEntity(StudentDto dto) {
        return new Student(dto.getEmail(), dto.getPassword());
    }
}
//
//
//    private Post convertToEntity(PostDto postDto) throws ParseException {
//    Post post = modelMapper.map(postDto, Post.class);
//    post.setSubmissionDate(postDto.getSubmissionDateConverted(
//            userService.getCurrentUser().getPreference().getTimezone()));
//
//    if (postDto.getId() != null) {
//        Post oldPost = postService.getPostById(postDto.getId());
//        post.setRedditID(oldPost.getRedditID());
//        post.setSent(oldPost.isSent());
//    }
//    return post;
//}