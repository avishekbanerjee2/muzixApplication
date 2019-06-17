import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router'

import { Muzix } from '../../muzix';
import { MuzixService } from '../../muzix.service'
import { MuzixUtility } from '../../muzix-utility';
import {SearchHistory} from '../../searchHistory'


@Component({
  selector: 'movie-tmdb-container',
  templateUrl: './tmdb-container.component.html',
  styleUrls: ['./tmdb-container.component.css']
})
export class TmdbContainerComponent implements OnInit {

  muzixs: Muzix[];
  muzix:Muzix;
  suggestedData: SearchHistory;
  

  constructor(private muzixService: MuzixService, private activeRoute: ActivatedRoute,private mUtil: MuzixUtility) { 
    this.muzixs=[];  
      
   
  }

  ngOnInit() {  
    
    this.muzixService.getSuggestedData()
    .subscribe((suggestedData) => {
      console.log('###############');
      console.log(suggestedData);
      this.suggestedData=suggestedData;
      console.log(this.suggestedData);


      this.muzixService.getSimilar(this.suggestedData.artistName,this.suggestedData.searchData).subscribe(
        (muzixs) => {
          for (let i=0;i<=muzixs.length;i++){
            this.muzix=new Muzix();
            let muzixArtist:any={};
          if(muzixs[i]!=null){
            this.muzix.name= muzixs[i].name;
            muzixArtist=muzixs[i].artist;
            this.muzix.artist=muzixArtist.name;
            this.muzix.url=muzixs[i].url;
            this.muzixs.push(this.muzix);
          }

          

            
          }
          
          console.log(this.muzixs);
        },
        (error) => {this.mUtil.snackBarErrorMessage(error,2000)}
      );



      },
      (error) => {this.mUtil.snackBarErrorMessage(error,2000)});  
      
  }
 

}
