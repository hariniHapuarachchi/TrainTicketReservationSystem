import {Component, OnInit} from '@angular/core';
import {SignIn} from "../dto/SignIn";
import {HttpClient} from "@angular/common/http";
import {$} from "protractor";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  num: number = 0;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.generateId();
  }

  addNIC(): void {

    let element = document.getElementById("myNic");

    element.style.setProperty("visibility", "visible");
    console.log("nic");
  }

  removeNIC(): void {
    let element = document.getElementById("myNic");

    element.style.setProperty("visibility", "hidden");
  }

  validationAndSave(psd1: string, psd2: string, name: string, email: string, r1: string, r2: string, id: number, nic: string): void {

    let status = null;
    if (psd1 != psd2) {
      alert("Given passwords doesn't match");

      let p2 = document.getElementById("p2");

      p2.style.setProperty("border", "red 2px solid");

    }

    if (name == "") {

      alert("Name is empty!!");

      let n = document.getElementById("name");

      n.style.setProperty("border", "red 2px solid");
    }

    let regexpEmail =
      new RegExp('^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$');

    let regexNic = new RegExp('^([0-9]{9})(X|V)$');

    console.log(regexNic.test(nic));

    if (email == "") {
      alert("Email is empty!!");

      let e = document.getElementById("email");

      e.style.setProperty("border", "red 2px solid");
    } else {

      if (regexpEmail.test(email) == false) {
        alert("Invalid Email !!");

        let n = document.getElementById("email");

        n.style.setProperty("border", "red 2px solid");
      }
    }

    function getRadioVal(form, name) {
      var val;
      var radios = form.elements[name];

      for (var i=0, len=radios.length; i<len; i++) {
        if ( radios[i].checked ) {
          val = radios[i].value;
          break;
        }
      }
      return val;
    }

    var val = getRadioVal( document.getElementById('demoForm'), 'inlineRadioOptions' );

    if (val == null) {
      alert("You must select the status");
    } else {

      if (val == r1) {

        if (regexNic.test(nic) == false) {
          alert("Invalid Nic !!");

          let n = document.getElementById("myNic");

          n.style.setProperty("border", "red 2px solid");
        }
      }
    }

    if (psd1 == psd2 && name != "" && regexpEmail.test(email) == true && val != null) {

      status = val;

    if(val == r2){
      nic = null;
      this.http.post('http://localhost:8080/api/v1/users', new SignIn(id, name, email, status, nic, psd1), {observe: 'response'})
        .subscribe(response => {
          if (response.status === 200) {
            alert("Registered Successfully !!")


          } else {
            alert('Faild to save the User');
          }
          this.generateId();
        });
    }else if(val == r1 && regexNic.test(nic) == true){
      this.http.post('http://localhost:8080/api/v1/users', new SignIn(id, name, email, status, nic, psd1), {observe: 'response'})
        .subscribe(response => {
          if (response.status === 200) {
            alert("Registered Successfully !! Now you can login to site");
          } else {
            alert('Faild to save the User');
          }
          this.generateId();
        });
    }
    }

    console.log("nic :" + nic);
    console.log("val :" + val);

  }

  clickTags(): void {
    let p2 = document.getElementById("p2");

    p2.style.setProperty("border", "white 2px solid");

    let n = document.getElementById("name");

    n.style.setProperty("border", "white 2px solid");

    let e = document.getElementById("email");

    e.style.setProperty("border", "white 2px solid");

    let iden = document.getElementById("myNic");
    iden.style.setProperty("border", "white 2px solid");
  }


  generateId(): void {
    this.http.get<any>('http://localhost:8080/api/v1/users').subscribe(value => {
      this.num = value.length + 1;
    });
  }
}
