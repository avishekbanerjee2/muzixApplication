import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';


import { ThumbnailComponent } from './components/thumbnail/thumbnail.component';
import { MuzixService } from './muzix.service';
import { ContainerComponent } from './components/container/container.component';
import { MuzixRouterModule } from './muzix-router.module';
import { BookmarkComponent } from './components/bookmark/bookmark.component';
import { TmdbContainerComponent } from './components/tmdb-container/tmdb-container.component';
import { MuzixDialogComponent } from './components/muzix-dialog/muzix-dialog.component';
import { MuzixSearchComponent } from './components/muzix-search/muzix-search.component';
import { MuzixUtility } from './muzix-utility';
import { TokenInterceptor } from './interceptor.service';
import { PlaylistComponent } from 'src/app/modules/muzix/components/playlist/playlist.component';


@NgModule({
  imports: [
    HttpClientModule,
    CommonModule,
    MatCardModule,
    MatButtonModule,
    MatSnackBarModule,
    MatDialogModule,
    FormsModule,
    MatInputModule,
    MuzixRouterModule,
    MatSelectModule
  ],
  declarations: [
    ThumbnailComponent,
    ContainerComponent,
    BookmarkComponent,
    TmdbContainerComponent,
    MuzixDialogComponent,
    MuzixSearchComponent,
    PlaylistComponent
  ],
  entryComponents: [MuzixDialogComponent],
  exports: [
    ContainerComponent,
    MuzixRouterModule,
    MuzixDialogComponent
  ],
  providers: [
    MuzixService,{ provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },
    MuzixUtility
  ]
})
export class MuzixModule { }
