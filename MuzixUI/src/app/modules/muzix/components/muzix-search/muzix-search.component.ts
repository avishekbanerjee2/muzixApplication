import { Component, OnInit } from '@angular/core';

import { Muzix } from '../../muzix';
import { MuzixService } from '../../muzix.service'
import { MuzixUtility } from '../../muzix-utility';
import {SearchHistory} from '../../searchHistory'

@Component({
  selector: 'muzix-muzix-search',
  templateUrl: './muzix-search.component.html',
  styleUrls: ['./muzix-search.component.css']
})
export class MuzixSearchComponent implements OnInit {
searchHistory:SearchHistory;
  muzixs: Muzix[];
  isPlaylistAdded:boolean=false;
  constructor(private muzixService: MuzixService, private mUtil: MuzixUtility) { }
  ngOnInit() {
  }

  onEnter(searchKey)
  {   

    this.searchMuzix(searchKey);
    }

  searchMuzix(searchKey){
    this.searchHistory=new SearchHistory();
    this.muzixService.searchMuzix(searchKey).subscribe(
      (muzixs) => {
        this.muzixs = muzixs;
        this.searchHistory.artistName=this.muzixs[0].artist;
        this.searchHistory.searchData=this.muzixs[0].name;
        this.muzixService.saveSearchHistory(this.searchHistory).subscribe(
     
          (error) => {this.mUtil.snackBarErrorMessage(error,2000)}
        );
      },
      (error) => {this.mUtil.snackBarErrorMessage(error,2000)}

      
    );
  }

}
