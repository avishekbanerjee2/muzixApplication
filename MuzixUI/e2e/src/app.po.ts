import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('app-root h1')).getText();
  }
  clickSignUpModalSignUpButton(){
    return element(by.id('register')).click();
  }
  clickAddToBookmarkList(){
    element.all(by.id('btn-add-to-bookmark')).first().click();
   }
   clickNavMyBookmarkist(){
    return element(by.id('btn-nav-my-bookmark')).click();
  }

  clickRemoveFromBookmarkList(){
    element.all(by.id('btn-remove-from-bookmark')).first().click();
   }

   clickNavSuugestedMuzix(){
    return element(by.id('btn-nav-suggested-muzixs')).click();
  }

  clickAddToPlayList(){
    element.all(by.id('btn-create-new-playlist')).first().click();
   }
   clickUpdatePlayList(){
    element.all(by.id('btn-add-to-exisiting-playlist')).first().click();
   }

   clickRemoveMyPlaylist(){
    element.all(by.id('btn-remove-from-playlist')).first().click();
   }

    clickAddToplaylistButton(){
    element.all(by.id('btn-add-to-playlist')).first().click();
   }

   


}
