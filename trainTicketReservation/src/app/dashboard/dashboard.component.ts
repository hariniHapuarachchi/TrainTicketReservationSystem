import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  customerCount: number = 10;
  resCount : number = 2;

  constructor(private http: HttpClient) { }

  ngOnInit() {

    document.getElementById("lButton").innerText == "Logout"
    //set the no of users in dashboard
    this.http.get<any>('http://localhost:8080/api/v1/users').subscribe(value => {
      this.customerCount = value.length;
    });

    //set the no of reservations in dashboard
    this.http.get<any>('http://localhost:8080/api/v1/reservations').subscribe(value => {
      this.resCount = value.length;
    });

  }

}

