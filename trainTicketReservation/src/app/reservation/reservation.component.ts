import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SignIn} from "../dto/SignIn";
import {Reservation} from "../dto/Reservation";
import {Router} from "@angular/router";

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  constructor(private http: HttpClient,public router: Router) { }

  amount : number = 0;
  id : number;
  ngOnInit() {
    this.loadId()
  }
  
  calculateAmount(train:string,count:number,user:number) : void{

    this.http.get<SignIn[]>('http://localhost:8080/api/v1/users/' + user)
      .subscribe(value => {

        //get status wheather if user is a government servant or not
        let status = value['status'];
        
        if (status == "government"){
          this.amount = count * 300;
          alert("You will get a 10% discount from the Total Amount!!Your total amount is : "+this.amount);//show total cost and notify the discount
          this.amount = count * 270;//add 10% discount
        }else {
          this.amount = count * 300;
        }
      });
  }

  saveReservation(user:number,date:string,time:string,count:number,totAmount:number,payMeth:string):void{

    let c = +count;//convert string value into a number
    let tot = +totAmount;//convert string value into a number

    if (date != "" && time != "" && count != null && totAmount != null && payMeth != ""){

      //get the list of reservations//
      this.http.get<any>('http://localhost:8080/api/v1/reservations').subscribe(value => {

        //generate the next value of the primary key//
        let i = 0;
        if (value.length == 0) {
          i = 1;
        } else {
          var num = value.length - 1;

          let resource = value[num];

          let ri = resource['reserveId'];

          i = ri + 1;

        }

        //save the reservation details//
        this.http.post('http://localhost:8080/api/v1/reservations', new Reservation(i, user, date, time, c, tot, payMeth), {observe: 'response'})
          .subscribe(response => {
            if (response.status === 200) {

              alert("Reserved Successfully !!");

              this.loadId();

              if (payMeth == "Mobile") {

                //direct to the payment page if payment method was mobile//
                this.router.navigate(['/mobile']);

              } else {
                //direct to the payment page if payment method was credit card//
                this.router.navigate(['/payment']);
              }

            } else {
              alert('Faild to Reserve re-enter the fields');
            }

          });
      });
    }

  }

  loadId(): void{
    //check wheather user is logged to the site
    if (document.getElementById("lButton").innerText == "Logout"){
      //get the list of login details
      this.http.get<any>('http://localhost:8080/api/v1/logins').subscribe(value => {

        var num = value.length - 1;

        let resource = value[num];

        let user = resource['id'];

        this.id = user;//get the user id at in last index

      });
    }else{
      console.log("Login to the site befor your reservation!!");
    }

  }
  
}
