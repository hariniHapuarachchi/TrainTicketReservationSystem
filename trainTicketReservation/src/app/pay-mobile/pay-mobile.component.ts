import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Payment} from "../dto/Payment";

@Component({
  selector: 'app-pay-mobile',
  templateUrl: './pay-mobile.component.html',
  styleUrls: ['./pay-mobile.component.css']
})
export class PayMobileComponent implements OnInit {

  id : number;
  digt: number;
  tot: number;
  constructor(private http: HttpClient,public router: Router) { }

  ngOnInit() {

    //load the related reservation id
    this.loadReserveId();

    //load a random 4 digit number
    var val = Math.floor(1000 + Math.random() * 9000);

    this.digt = val;
  }

  validationAndSave(user:number,mobile:number,num:number): void{

    let m = +mobile;
    let n = +num;

    //save the payment details only if mobile number isn't empty
    if (m != null) {

      //get the list of the payment details to generate the next value of the primary key
      this.http.get<any>('http://localhost:8080/api/v1/payments').subscribe(value => {

        let i = 0;
        if (value.length == 0){
          i = 1;
        }else {
          var num = value.length - 1;
          console.log(value[num]);

          let resource = value[num];

          let ri = resource['id'];

          i = ri + 1;

        }
        //save the payment details
        this.http.post('http://localhost:8080/api/v1/payments', new Payment(i,user, "", null, "", m, n), {observe: 'response'})
          .subscribe(response => {
            if (response.status === 200) {

              alert("Paid Successfully !!");

              this.loadReserveId();

              //redirect to the reservation page to make more reservations
              this.router.navigate(['/reservation']);


            } else {
              alert('Faild to pay');
            }

          });
      });

    }else{
      alert("Mobile Number and Password shouldn't be empty!");
    }
  }

  loadReserveId(): void{

    //get list of the reservation details
      this.http.get<any>('http://localhost:8080/api/v1/reservations').subscribe(value => {

        var num = value.length - 1;

        let resource = value[num];//get the object of last index

        let amount = resource['amount'];//get value of the amount from resource object

        let u = resource['reserveId'];//get reserve id from the resource object

        this.tot = amount;

        this.id = u;

      });

  }

}
