import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SignIn} from "../dto/SignIn";
import {forEach} from "@angular/router/src/utils/collection";
import {el} from "@angular/platform-browser/testing/src/browser_util";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  s : SignIn[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  validation(userId: number,psd: string): void{

      // this.http.get<any>('http://localhost:8080/api/v1/users').subscribe((value : any[][]) => {

        // this.s = [];
        // for (let i=0;i < value.length;i++){
        //   console.log(Object.values(value.values().next().value).values().next().value);
        // }

        // console.log(Object(value.values().next().value).values().next().value);
        // let i = Object.getOwnPropertyNames(value.values().next().value).values().next().value;
        // console.log(Object.getPrototypeOf(value.values().next().value).values().next().value)
        // console.log(Object.getOwnPropertySymbols(value.values().next().value).values().next().value)
        // console.log(Object.prototype.constructor);
        // var obj = {};
        // obj = value.values().next().value;
        //
        // console.log(obj.constructor.arguments)
        // console.log(Object.getOwnPropertyNames(value.values().next().value).values().next().value);
        // console.log(Object.values(value.values().next().value).values().next().value);

      // });
    if (userId == null) {
      alert("User ID is empty!");

      let u = document.getElementById("uId");

      u.style.setProperty("border","red 2px solid");
    }

    if (psd == ""){

      alert("Password ID is empty!");

      let p = document.getElementById("passwd");

      p.style.setProperty("border","red 2px solid");

    }

    if(userId != null && psd != ""){

    }


  }

  clickTags(): void{
    let p = document.getElementById("passwd");

    p.style.setProperty("border","white 2px solid");

    let u = document.getElementById("uId");

    u.style.setProperty("border","white 2px solid");

  }

}
