import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SignIn} from "../dto/SignIn";
import {forEach} from "@angular/router/src/utils/collection";
import {el} from "@angular/platform-browser/testing/src/browser_util";
import {Login} from "../dto/Login";
import {Session} from "selenium-webdriver";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  constructor(private http: HttpClient) {}

  ngOnInit() {
  }

  validation(userId: number,psd: string): void{

    //check wheather user id is empty//
    if (userId == null) {
      alert("User ID is empty!");

      let u = document.getElementById("uId");

      u.style.setProperty("border","red 2px solid");//highlight the input field
    }

    //check wheather user password is empty//
    if (psd == ""){

      alert("Password ID is empty!");

      let p = document.getElementById("passwd");

      p.style.setProperty("border","red 2px solid");

    }

    //Save the login details only if user id and passowrd is not empty//
    if(userId != null && psd != ""){

      //get details of the given user id
      this.http.get<SignIn[]>('http://localhost:8080/api/v1/users/' + userId)
        .subscribe(value => {

          let d = new Date();
          let ds = d.toString();
          let lt = "";

          //check wheather given user id and password is match to the user details in database//
          if (userId == value['id'] && psd == value['password']){
            //save the login details with login time
            this.http.post('http://localhost:8080/api/v1/logins', new Login(userId,ds,lt), {observe: 'response'})
              .subscribe(response => {
                if (response.status === 200) {

                  alert("Logged Successfully !!")
                  //chenge the button value into logout
                  document.getElementById("lButton").innerText = "Logout";

                } else {
                  alert('Faild to Login');
                }

              });
          }else {
            alert("Invalid User Id or Password");
            //highlight invalid input fields
            let u = document.getElementById("uId");
            u.style.setProperty("border","red 2px solid");
            let p = document.getElementById("passwd");
            p.style.setProperty("border","red 2px solid");
          }
        });



    }


  }

  //remove the highlight colour of the invalid input field by mouse click
  clickTags(): void{
    let p = document.getElementById("passwd");

    p.style.setProperty("border","white 2px solid");

    let u = document.getElementById("uId");

    u.style.setProperty("border","white 2px solid");

  }

}
