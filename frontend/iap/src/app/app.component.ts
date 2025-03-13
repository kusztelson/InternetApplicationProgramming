import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HelloService } from './services/hello.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent implements OnInit {
  title = 'iap';
  hello?: Observable<String>;

  constructor(private helloService: HelloService) {
  }

  ngOnInit(): void {
    this.hello = this.helloService.getHello()
  }
}
