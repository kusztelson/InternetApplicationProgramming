import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { LoginService } from '../login/login.service';

export const userGuard: CanActivateFn = (route, state) => {
  return inject(LoginService).getUserRole() == 'ROLE_USER';
};
