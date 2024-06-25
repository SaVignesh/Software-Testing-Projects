import {test,expect} from '@playwright/test';
import {LoginPage} from '../pageObjects/LoginPage';
//import {testData} from '../testData/testData.json';
const testData = JSON.parse(JSON.stringify(require('../testData/testData.json')))

const url = testData.url;
const username = testData.username;
const password = testData.password;

test('test_login_page @smoke',async({page}) => {
    const login = new LoginPage(page);
    await login.goToLoginPage(url);
    await login.checkLoginPageURL();
    
})

test('test_login_action @sanity', async ({page}) => {
    const login = new LoginPage(page);
    await login.goToLoginPage(url)
    await login.login_action(username,password)
    await login.checkDashboardPageURL()
})