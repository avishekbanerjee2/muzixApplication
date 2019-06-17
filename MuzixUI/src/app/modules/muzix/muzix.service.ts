import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators/map';
import { Observable } from 'rxjs/Observable';
import { retry } from 'rxjs/operators';

import { Muzix } from './muzix';
import { Playlist } from 'src/app/modules/muzix/playlist';
import {Bookmark} from './bookmark';
import {SearchHistory} from './searchHistory';


@Injectable()
export class MuzixService {

  apiKey: string;
  tmdbEndPoint: string;
  imagePrefix: string;
  watchlistEndpoint: string;
  searchMuzixEndpoint: string;
  getSimilarEndpoint: string;
  getInfoEndPoint:string;

  constructor(private http: HttpClient) {
    this.apiKey = 'api_key=e84b15f8f94ed3577c8b43cca48e742c';
    this.tmdbEndPoint = 'https://api.themoviedb.org/3/movie';
    this.imagePrefix = 'https://image.tmdb.org/t/p/w500';
    this.watchlistEndpoint = 'http://localhost:8082/api/v1/muzixService';
    this.searchMuzixEndpoint = 'http://ws.audioscrobbler.com/2.0/?method=track.search';
    this.getSimilarEndpoint = 'http://ws.audioscrobbler.com/2.0/?method=track.getsimilar';
    this.getInfoEndPoint = 'http://ws.audioscrobbler.com/2.0/?method=track.getInfo'

    //http://ws.audioscrobbler.com/2.0/?method=track.getsimilar
  }
  
  

 

  pickMuzixResults(response) {


    console.log(response['results'].trackmatches.track);
    
    return response['results'].trackmatches.track;
  }


  picSuggestedkMuzixResults(response) {

    console.log('Avishek Banerjee');
    console.log(response['similartracks'].track);
    
    return response['similartracks'].track;
  }


  pickMuzixInfoResults(response) {

    
    console.log(response['track']);
    
    return response['track'];
  }

  searchMuzix(searchKey: string, page: number = 1): Observable<Array<Muzix>> {
    if (searchKey.length > 0) {
      const endpoint = `${this.searchMuzixEndpoint}&track=${searchKey}&${this.apiKey}&format=json`;           
      return this.http.get(endpoint).pipe(
        retry(3),
        map(this.pickMuzixResults),
        //map(this.transformPosterPath.bind(this))
      );
    }
    return null;
  }
  searchMuzixinfo(artist: string, title: string): Observable<Array<Muzix>> {
    if (artist.length > 0 && title.length>0) {
      const endpoint = `${this.getInfoEndPoint}&${this.apiKey}}&artist=${artist}&track=${title}&format=json`;   
            
      return this.http.get(endpoint).pipe(
        retry(3),
        map(this.pickMuzixInfoResults),
        //map(this.transformPosterPath.bind(this))
      );
    }
    return null;
  }

  getSimilar(searchKey: string,artist:string, page: number = 1): Observable<Array<Muzix>> {
    if (searchKey.length > 0) {
      const endpoint = `${this.getSimilarEndpoint}&artist=${searchKey}&track=${artist}&${this.apiKey}&format=json`; 
      return this.http.get(endpoint).pipe(
        retry(3),
        map(this.picSuggestedkMuzixResults),
        //map(this.transformPosterPath.bind(this))
      );
    }
    return null;
  }

  addMuzixToBookmark(muzix) {
    console.log('ami k:');
    console.log(`${this.watchlistEndpoint}/muzix`);
    return this.http.post(`${this.watchlistEndpoint}/createbookmark`, muzix);
  }
  
  getBookMarkMuzixs(): Observable<Bookmark[]> {
    return this.http.get<Bookmark[]>(`${this.watchlistEndpoint}/bookmark`);
  }

  getPlaylist(): Observable<Playlist[]> {
    return this.http.get<Playlist[]>(`${this.watchlistEndpoint}/getPlaylistByUser`);
  }

  removeFromBookmark(muzix) {
    const url = `${this.watchlistEndpoint}/muzix/bookmark/${muzix.bookmarkId}`;    
    return this.http.delete(url, { responseType: 'text' });
  }

  removeFromPlayList(muzix) {
    console.log(muzix);
    const url = `${this.watchlistEndpoint}/muzix/deletePlaylist/${muzix.playListId}/${muzix.muzixId}`;    
    return this.http.delete(url, { responseType: 'text' });
  }

  updateWatchlistMovie(movie) {
    const url = `${this.watchlistEndpoint}/movie/${movie.id}`;
    return this.http.put(url, movie);
  }
  createPlayList(Playlist) {
    const url = `${this.watchlistEndpoint}/createPlaylist`;
    return this.http.post(url, Playlist);
  }

  updatePlaylist(Playlist) {
    const url = `${this.watchlistEndpoint}/updatePlaylist`;
    return this.http.post(url, Playlist);
  }

  saveSearchHistory(searchHistory) {
    console.log('data-------------');
    console.log(searchHistory);
    const url = `${this.watchlistEndpoint}/saveSearchHistory`;
    return this.http.post(url, searchHistory);
  }
  getSuggestedData(): Observable<SearchHistory> {
    return this.http.get<SearchHistory>(`${this.watchlistEndpoint}/suggested`);
  }
}
