import {Injectable} from '@angular/core';
import {BehaviorSubject,Observable, map} from 'rxjs';
import {User} from '../models/user';

import {HttpClient, HttpErrorResponse,HttpHeaders} from '@angular/common/http';

@Injectable()
export class ServiceuserService {
  private readonly API_URL = 'http://localhost:9999/clients/getClient';
 
  dataChange: BehaviorSubject<User[]> = new BehaviorSubject<User[]>([]);

  
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor (private httpClient: HttpClient) {}

 /* getAllUsers(): void {

    this.httpClient.get<User[]>(this.API_URL).subscribe(data => {
        this.dataChange.next(data[0]);
        console.log(data[0])
      },
      (error: HttpErrorResponse) => {
      console.log (error.name + ' ' + error.message);
      });
  }
*/
  getAllUsers(): Observable<any[]> {
    return this.httpClient.get<User[]>(this.API_URL);
  }


  deleteUser (id: number): void {
    console.log(id);
    this.httpClient.delete(this.API_URL+'/deleteClient/'+id)
    .subscribe(data=>{
      console.log(data);
    })
  }

 updateUser (user: User,id: number): void {
    
    this.httpClient.put(this.API_URL+'/'+id, JSON.stringify(user), this.httpOptions)
    .subscribe(data=>{
      console.log(data);
    })
  }



}

