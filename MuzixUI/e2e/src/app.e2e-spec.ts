import { AppPage } from './app.po';

describe('FrontEnd App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display Title', () => {
    page.navigateTo();
    expect(browser.getTitle()).toEqual('MuzixUI');
  });
  
  it('should navigate to login page when application is launched', () => {
    expect(browser.getCurrentUrl()).toContain('/login');
  });

  it('should navigate to register screen when register button is clicked', () => {
    browser.element(by.id('register')).click();
    expect(browser.getCurrentUrl()).toContain('/register');
  });

  it('should be able to register new user', () => {
    browser.element(by.id('firstName')).sendKeys('Robert');
    browser.element(by.id('lastName')).sendKeys('Russell');
    browser.element(by.id('userId')).sendKeys('robert');
    browser.element(by.id('password')).sendKeys('test1234');
    page.clickSignUpModalSignUpButton();
    expect(browser.getCurrentUrl()).toContain('/login');
  });

  it('should be able to login using existing username and password and navigate to muzix search', () => {
    browser.element(by.id('userId')).sendKeys('robert');
    browser.element(by.id('password')).sendKeys('test1234');
    browser.element(by.id('logIn')).click();
    expect(browser.getCurrentUrl()).toContain('/search');
  });

  it('should be able to search muzix', () => {
    browser.element(by.id('btn-nav-search-muzixs')).click();
    expect(browser.getCurrentUrl()).toContain('/search');
    browser.element(by.id('searchMuzix')).sendKeys('Believe');
    browser.element(by.id('searchMuzix')).sendKeys(protractor.Key.ENTER);

    const searchItems = element.all(by.css('.card-text'));
    expect(searchItems.get(0).getText()).toContain('Imagine Dragons');
    /*for (let i=0; i<2; i++){
      expect(searchItems.get(i).getText()).toContain('The Killer');
    }*/
    
  });

  it('Should be able to add muzixs in bookmark from search page', () => {
    //browser.pause(2000);
    page.clickAddToBookmarkList();
  });

  it('Should navigate to my bokmark page', () => {
    browser.element(by.id('btn-nav-my-bookmark')).click();
    expect(browser.getCurrentUrl()).toContain('/bookmark');
   
  });

  it('Should be able to remove muzixs from bookmark', () => {
    //browser.pause(2000);
    page.clickRemoveFromBookmarkList();
  });

  it('Should navigate to suggested muzix page', () => {
    browser.element(by.id('btn-nav-suggested-muzixs')).click();
    expect(browser.getCurrentUrl()).toContain('/suggest');
   
  });

  it('Should be able to add muzixs in bookmark from suggested muzix page', () => {
    //browser.pause(2000);
    page.clickAddToBookmarkList();
  });

  it('Should be able to add muzixs in new playlist from search page', () => {
    browser.element(by.id('btn-nav-search-muzixs')).click();    
    browser.element(by.id('searchMuzix')).sendKeys('Believe');
    browser.element(by.id('searchMuzix')).sendKeys(protractor.Key.ENTER);
    browser.pause(2000);
    browser.element(by.id('btn-add-to-playlist')).click();
    browser.element(by.id('text-new-playlist')).sendKeys('E2E PlayList');
    page.clickAddToPlayList();
    //browser.pause(2000);
    //
    //browser.element(by.id('btn-create-new-playlist')).click();
  });


  /*it('Should be able to add muzixs in existing playlist from suggested page', () => {

    browser.element(by.id('btn-nav-search-muzixs')).click();
    expect(browser.getCurrentUrl()).toContain('/search');
    browser.element(by.id('searchMuzix')).sendKeys('Believe');
    browser.element(by.id('searchMuzix')).sendKeys(protractor.Key.ENTER);
       
    browser.pause(2000);
    //browser.element(by.id('btn-add-to-playlist')).click();    
    page.clickAddToplaylistButton();
    browser.pause(2000);
    browser.element(by.id('dd-exisiting-playlist')).sendKeys('E2E PlayList');   
    page.clickUpdatePlayList(); 
    //browser.element(by.id('btn-add-to-exisiting-playlist')).click();
  });*/

  it('Should navigate to my playlist page', () => {
    browser.element(by.id('btn-nav-my-playlist')).click();
    expect(browser.getCurrentUrl()).toContain('/playlist');
   
  });

  it('Should be able to remove muzixs from playlist', () => {
    //browser.pause(2000);
    page.clickRemoveMyPlaylist();
  });

  it('should be able to logout user', () => {
    browser.element(by.id('logout')).click();
    expect(browser.getCurrentUrl()).toContain('/login');
  });

});
