import { Component, OnInit } from '@angular/core';

import { Muzix } from '../../muzix';
import { MuzixService } from '../../muzix.service'
import { MuzixUtility } from '../../muzix-utility';
import { Playlist } from 'src/app/modules/muzix/playlist';

@Component({
  selector: 'muzix-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {

  playlists: Playlist[]=[];
  isPlaylistAdded:boolean=true;
  constructor(private muzixService: MuzixService, private mUtil: MuzixUtility) { }

  ngOnInit() {
    this.muzixService.getPlaylist().subscribe(
      (playlists) => {
        
        this.playlists.push(...playlists);
        
      },
      (error) => {this.mUtil.snackBarErrorMessage(error,2000)}
    );
  
    //console.log(this.data);
  }

  

}