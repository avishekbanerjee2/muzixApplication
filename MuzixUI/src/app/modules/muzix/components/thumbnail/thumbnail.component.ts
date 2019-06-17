import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';


import { Muzix } from '../../muzix';
import { MuzixService } from '../../muzix.service';
import { MuzixDialogComponent } from '../muzix-dialog/muzix-dialog.component';



@Component({
  selector: 'muzix-thumbnail',
  templateUrl: './thumbnail.component.html',
  styleUrls: ['./thumbnail.component.css']
})

export class ThumbnailComponent implements OnInit {

  @Input()
  muzix: Muzix;

  @Input()
  useWatchlistApi: boolean;

  @Input()
  isPlaylistAdded:boolean;
  @Input()
  playlistId:number;

  @Output()
  addMuzix = new EventEmitter();

  @Output()
  deleteMuzix = new EventEmitter();


  constructor(private muzixService: MuzixService, private snackBar: MatSnackBar,private matDlg: MatDialog) {
   
  }

  ngOnInit() {
  }
  removeFromPlayList() {
    this.muzix.playListId=this.playlistId;
    
    this.deleteMuzix.emit(this.muzix);    
  }

  addToBookmark() {
    this.addMuzix.emit(this.muzix);    
  }

  removeFromBookmark(){
    this.deleteMuzix.emit(this.muzix);    
  }
  //
  addToPlayList(actionType) {
    let dialogRef = this.matDlg.open(MuzixDialogComponent,
      {
        width:"600px",
        height:"600px",
        data: {obj: this.muzix,actionType: actionType}
      });
      console.log("open the dialog");
      dialogRef.afterClosed().subscribe((results)=>{
        console.log("this dialog was closed");
      })
    }

    
}