import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  private baseUrl = 'http://localhost:9999/clients/';

  constructor(private http:HttpClient) { }


  getUserbyName(name: String)
  {
    return this.http.get(`${this.baseUrl}`+'allByName/'+name);
  }

  getUserList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'getClients');
  }

  createUser(user: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'addClient', user);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}delete/${id}`, { responseType: 'text' });
  }

  getUser(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}getClientById/${id}`);
  }

  updateUser(id: number | undefined, value: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}update-student/${id}`, value);
  }
  
}                                           