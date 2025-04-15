import { HttpInterceptorFn } from '@angular/common/http';
import { LoginService } from '../login/login.service';
import { inject } from '@angular/core';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authToken = inject(LoginService).getAuthHeader();

  if(authToken) {
    const newReq = req.clone({
      headers: req.headers.set('Authorization', authToken),
    });
    return next(newReq)
  }  
  return next(req);
};
