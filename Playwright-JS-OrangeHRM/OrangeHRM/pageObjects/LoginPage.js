import { expect } from "@playwright/test";
const testData = JSON.parse(JSON.stringify(require('../testData/testData.json')))

const baseURL = testData.url;
const baseUsername = testData.username;
const basePassword = testData.password;

exports.LoginPage = class LoginPage {
    constructor(page){
        this.page = page;
        //Locators
        this.txt_username_css = page.locator("input[name='username']");
        this.txt_password_css = page.locator("input[name='password']");
        this.btn_login_css = page.locator("button[type='submit']");
    }
    async goToLoginPage(url){
        await this.page.goto(url);
    }
    async checkLoginPageURL(){
        await expect.soft(this.page).toHaveURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    async login_action(username,password){
        await this.txt_username_css.fill(username)
        await this.txt_password_css.fill(password)
        await this.btn_login_css.click()
    }
    async checkDashboardPageURL(){
        await expect.soft(this.page).toHaveURL("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")
    }
    async login(){
        await this.page.goto(baseURL);
        await this.txt_username_css.fill(baseUsername);
        await this.txt_password_css.fill(basePassword);
        await this.btn_login_css.click();
    }
}