import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

import { Muzix } from '../../muzix';
import { MuzixService } from '../../muzix.service';
import { HttpErrorResponse } from '@angular/common/http';
import {MuzixUtility} from '../../muzix-utility';
import { Playlist } from 'src/app/modules/muzix/playlist';

@Component({
  selector: 'muzix-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.css']
})
export class ContainerComponent implements OnInit {

  @Input()
  //muzixs: Muzix[];
  muzixs:Array<Muzix>;

  @Input()
  playlists: Array<Playlist> = [];

  @Input()
  useWatchlistApi: boolean;
  @Input()
  isPlaylistAdded:boolean;
  


  

  isMovieDeleted: boolean = false;

  constructor(private muzixService: MuzixService, private activeRoute: ActivatedRoute, 
    private snackBar: MatSnackBar, private mUtil: MuzixUtility) {

  }

  ngOnInit() {


  }

  addToBookmark(muzix) {
    //console.log(muzix);
    this.muzixService.addMuzixToBookmark(muzix).subscribe(
      (muzix) => { this.snackBar.open('Muzix added to Bookmark', '', { duration: 2000 }); },
      (error) => {this.mUtil.snackBarErrorMessage(error,2000)}
    );
  }
  removeFromPlayList(muzix){

    let message = `${muzix.name} removed from playlist`;
    let muzixId = muzix.muzixId;
    this.muzixService.removeFromPlayList(muzix).subscribe(
      (muzix) => {
        this.snackBar.open(message, '', { duration: 2000 });
        //console.log(this.muzixs.length);
        for (var j = 0; j < this.playlists.length; j++) {
        for (var i = 0; i < this.playlists[j].muzixs.length; i++) {         
          if (this.playlists[j].muzixs[i].muzixId == muzixId) {
            this.playlists[j].muzixs.splice(i, 1);
          }
        }
      }
      },
      (error) => {this.mUtil.snackBarErrorMessage(error,2000)}
    );
    
    /*this.muzixService.removeFromPlayList(muzix).subscribe(
      (muzix) => { this.snackBar.open('Muzix removed from playlist', '', { duration: 2000 }); },
      (error) => {this.mUtil.snackBarErrorMessage(error,2000)}
    );*/
  }

  addToPlayList(muzix){
    
  }

  deletMuzixFromBookmark(muzix) {
    let message = `${muzix.name} deleted from Bookmark`;
    let muzixId = muzix.muzixId;
    this.muzixService.removeFromBookmark(muzix).subscribe(
      (muzix) => {
        this.snackBar.open(message, '', { duration: 2000 });
        console.log(this.muzixs.length);
        for (var i = 0; i < this.muzixs.length; i++) {         
          if (this.muzixs[i].muzixId == muzixId) {
            this.muzixs.splice(i, 1);
          }
        }
      },
      (error) => {this.mUtil.snackBarErrorMessage(error,2000)}
    );
  }
}