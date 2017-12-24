/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author User
 */
@Path("students")
public class UserResource {
    private static final List<Student> list=new ArrayList<>();
    @GET
    @Path("all")
    @Produces("application/xml")
    public List<Student> getAllStudent(){
        Collections.addAll(list, new Student(1, "Thaw Thaw", 23, "Latha"),
                new Student(2, "Maw Maw", 22, "Mdy"),
                new Student(3, "Lwin Lwin", 22, "Latha"),
                new Student(4, "Thura", 22, "Mdy"));
        return list;
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Student findStudentById(@PathParam("id")int studentid){
        for(Student s:list){
            if(s.getStudent_id()==studentid){
                return s;
            }
        }
        return null;
    }
}
