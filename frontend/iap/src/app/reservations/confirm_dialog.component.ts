import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-confirm-dialog',
  standalone: true,
  imports: [MatDialogModule, MatButtonModule], 
  template: `
    <h2 mat-dialog-title>Cancel Reservation</h2>
    <mat-dialog-content>
      <p>Are you sure you want to cancel this reservation?</p>
    </mat-dialog-content>
    <mat-dialog-actions align="end">
      <button mat-button (click)="onNoClick()">No</button>
      <button mat-button color="warn" (click)="onConfirm()">Yes</button>
    </mat-dialog-actions>
  `
})
export class ConfirmDialogComponent {
  constructor(private dialogRef: MatDialogRef<ConfirmDialogComponent>) {}

  onNoClick(): void {
    this.dialogRef.close(false);
  }

  onConfirm(): void {
    this.dialogRef.close(true);
  }
}

export default ConfirmDialogComponent;