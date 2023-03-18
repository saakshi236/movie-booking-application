import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../class/user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) {
    var session = sessionStorage.setItem('user', 'value');
  }

  public logicUserFromRest(user: User): Observable<any> {
    return this.http.post<any>("http://localhost:8090/login", user)
  }

  public registerUser(user: User): Observable<any> {
    return this.http.post<any>("http://localhost:8090/register", user)
  }
}
