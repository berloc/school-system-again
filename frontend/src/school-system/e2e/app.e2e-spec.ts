import { SchoolSystemPage } from './app.po';

describe('school-system App', function() {
  let page: SchoolSystemPage;

  beforeEach(() => {
    page = new SchoolSystemPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
