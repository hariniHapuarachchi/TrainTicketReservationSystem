import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Payment} from "../dto/Payment";
import {SignIn} from "../dto/SignIn";
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  id : number;
  email:number;
  tot: number;
  constructor(private http: HttpClient,public router: Router) { }

  ngOnInit() {
    this.loadReserveId();
  }

  validationAndSave(user:number,credit:string,cvc:number,name:string): void{

    let c = +cvc;

    //cehck wheather if credit card number and name is not empty
    if (credit != "" && c != null && name != "") {

      //get list of the payment details to generate the next value of the primary key//
      this.http.get<any>('http://localhost:8080/api/v1/payments').subscribe(value => {

        let i = 0;
        if (value.length == 0) {
          i = 1;
        } else {
          var num = value.length - 1;

          let resource = value[num];

          let ri = resource['id'];

          i = ri + 1;

        }

        //save the payment details
        this.http.post('http://localhost:8080/api/v1/payments', new Payment(i, user, credit, c, name, null, null), {observe: 'response'})
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

    //get the list of the reservation details
    this.http.get<any>('http://localhost:8080/api/v1/reservations').subscribe(value => {

      var num = value.length - 1;

      let resource = value[num];//get the object of last index

      let user = resource['id'];//get the value of the id from resource object

      let amount = resource['amount'];//get value of the amount from resource object

      this.tot = amount;
      let u = resource['reserveId'];

      this.id = u;

      //get the details realated to the given user id
      this.http.get<SignIn[]>('http://localhost:8080/api/v1/users/' + user)
        .subscribe(value => {
          this.email = value['email'];//set the email as value of the email input field
        });

    });

  }
}
