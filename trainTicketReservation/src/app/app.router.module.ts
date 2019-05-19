import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from './dashboard/dashboard.component';
import {LoginComponent} from './login/login.component';
import {ReservationComponent} from './reservation/reservation.component';
import {PaymentComponent} from './payment/payment.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {PayMobileComponent} from './pay-mobile/pay-mobile.component';
import {SignInComponent} from './sign-in/sign-in.component';

const appRoutes: Routes = [
  {
    path: 'dashboard',
    component: DashboardComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'reservation',
    component: ReservationComponent
  },
  {
    path: 'payment',
    component: PaymentComponent
  },
  {
    path: 'sign-in',
    component: SignInComponent
  },
  {
    path: 'mobile',
    component: PayMobileComponent
  },
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})
export class AppRouterModule { }
