import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { HelloService } from './hello.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-hello',
  imports: [CommonModule],
  templateUrl: './hello.component.html',
  styleUrl: './hello.component.scss'
})
export class HelloComponent implements OnInit {
  hello$?: Observable<String>

  constructor(private service: HelloService) {}
  
  ngOnInit(): void {
    this.hello$ = this.service.getHello()
  }
}
