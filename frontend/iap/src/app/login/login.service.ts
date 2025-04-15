import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import Login from './login';

type IRole = "ROLE_USER" | "ROLE_ADMIN" | "ROLE_MANAGER"

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private _authorization?: string;
  private _user?: { id: string; role: IRole};

  constructor(private http: HttpClient) { }

  public login(login: Login) {
    this._authorization = "Basic " + btoa(login.username + ":" + login.password);
    this.getRole(login.username);
  }

  public getAuthHeader(): string | null {
    if(this._authorization) {
      return this._authorization;
    }
    else {
      return null;
    }
  }

  public getUserRole(): IRole | null {
    if(this._user?.role) {
      return this._user.role;
    }
    else {
      return null;
    }
  }

  private getRole(username: string) {
    this.http.get<{ id: string; role: IRole}>(environment.apiUrl + `rentUser/login/${username}`)
      .subscribe(user => this._user = {...user});
  }
}
