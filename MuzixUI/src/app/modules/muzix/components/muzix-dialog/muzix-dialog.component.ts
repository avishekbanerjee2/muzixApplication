import { NgModule, Component, OnInit, Inject } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

import { Muzix } from '../../muzix';
import { MuzixService } from '../../muzix.service';
import { MuzixUtility } from '../../muzix-utility';
import {Playlist} from '../../playlist';
import { Console } from '@angular/core/src/console';

@Component({
  selector: 'muzix-movie-dialog',
  templateUrl: './muzix-dialog.component.html',
  styleUrls: ['./muzix-dialog.component.css']
})
export class MuzixDialogComponent implements OnInit {

  muzix: Muzix;
  selectedPlaylist: number;
  actionType: string;
  newplaylistName:string;
  playlists: Playlist[]=[];
  newPlaylist: Playlist;
  muzixs:Muzix[]=[];

  constructor(private snackBar: MatSnackBar, private dialogRef: MatDialogRef<MuzixDialogComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any, private muzixService: MuzixService, 
    private mUtil: MuzixUtility) {
    this.muzix = data.obj;
    this.actionType = data.actionType;
    this.selectedPlaylist = data.obj.selectedPlaylist;
  }

  ngOnInit() {
    this.muzixService.getPlaylist().subscribe(
      (playlists) => {
        console.log(playlists);
        this.playlists.push(...playlists);
        console.log(this.playlists);
      },
      (error) => {this.mUtil.snackBarErrorMessage(error,2000)}
    );

  }

  onNoClick()
  {
    this.dialogRef.close();
  }

  createPlaylist()
  {
    console.log("playlist",this.newplaylistName);
    if(this.newplaylistName!=null && this.newplaylistName.trim().length>0){
      //this.movie.comments=this.comments;
      this.dialogRef.close();

    this.newPlaylist=new Playlist();
    this.newPlaylist.playlistName=this.newplaylistName;
    
    this.newPlaylist.muzixs.push(this.muzix);
      this.muzixService.createPlayList(this.newPlaylist).subscribe(
        (muzix) => {
          this.snackBar.open('playlist Muzix updated ', '', { duration: 2000 }); 
        },
        (error) => {this.mUtil.snackBarErrorMessage(error,2000)}
      );
    }   
   }


  addToPlaylist()
  {
    console.log("playlist",this.selectedPlaylist);    
    if(this.selectedPlaylist!=null){
      //this.movie.comments=this.comments;
      this.dialogRef.close();
      

    this.newPlaylist=new Playlist();
    this.newPlaylist.playlistId =this.selectedPlaylist;
    this.newPlaylist.muzixs.push(this.muzix);
      this.muzixService.updatePlaylist(this.newPlaylist).subscribe(
        (muzix) => {
          this.snackBar.open('Muzix added to playlist', '', { duration: 2000 }); 
        },
        (error) => {this.mUtil.snackBarErrorMessage(error,2000)}
      );
    }   
   }

}