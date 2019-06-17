import { Component, OnInit } from '@angular/core';

import { Muzix } from '../../muzix';
import { MuzixService } from '../../muzix.service';
import {MuzixUtility} from '../../muzix-utility';


@Component({
  selector: 'muzix-bookmark',
  templateUrl: './bookmark.component.html',
  styleUrls: ['./bookmark.component.css']
})
export class BookmarkComponent implements OnInit {

  muzixs: Muzix[]=[];
  useWatchlistApi = true;
  isPlaylistAdded = false;
  constructor(private muzixService: MuzixService,private mUtil: MuzixUtility) { 
    this.muzixs=[]; 
  }

  ngOnInit() {
    this.muzixService.getBookMarkMuzixs().subscribe(
      (bookmarks) => {
       //console.log('ahsghas',bookmarks);
       if(bookmarks!=null){
        for(let i=0;i<bookmarks.length;i++){
          let tempMuzix:Muzix=  bookmarks[i].muzix;
          tempMuzix.bookmarkId=bookmarks[i].bookmarkId;
         this.muzixs.push(tempMuzix);
        }
       }
       
       
        console.log('hgj',this.muzixs);
      },
      (error) => {this.mUtil.snackBarErrorMessage(error,2000)}
    );
  }

}