import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookingsComponent } from './components/bookings/bookings.component';
import { ErrorComponent } from './components/error/error.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { LoginComponent } from './components/login/login.component';
import { MovieBookingComponent } from './components/movie-booking/movie-booking.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';


const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'home', component: HomepageComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'bookMovie/:id', component: MovieBookingComponent },
  { path: 'bookings', component: BookingsComponent },
  { path: 'updateMovie/:id', component: UpdateBookingComponent },
  { path: 'error', component: ErrorComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
