import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Login} from "./dto/Login";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'trainTicketReservation';

  login: Login[] = [];
  constructor(private http: HttpClient) { }

  logoutFromSite(): void{

    //check if user still logged in the site
    if (document.getElementById("lButton").innerText == "Logout"){

      //get the list of the login details
    this.http.get<any>('http://localhost:8080/api/v1/logins').subscribe(value => {

        var num = value.length - 1;

      let resource = value[num];//get the json object of last index

      let ld = resource['loginTime'];//get the login time of the resource object
      let od = resource['logoutTime'];//get the logout time of the resource object

      let uId = resource['id'];//get the user id of the resource object

      let d = new Date();//get current date
      let ds = d.toString();//pass the date into string value

      //update the logout time
      this.http.put('http://localhost:8080/api/v1/logins/'+ld,{loginTime:""+ld+"",id:""+uId+"",logoutTime:""+ds+""},{observe: 'response'})
        .subscribe(response => {
          if (response.status === 200) {

            alert("Logout Successfully !!");
            //change the value of the button to login if successfully logout
            document.getElementById("lButton").innerText = "Login";

          } else {
            document.getElementById("lButton").innerText = "Login";
          }

        });

    });
    }else{
      console.log("Login to the system");
    }
  }


}
