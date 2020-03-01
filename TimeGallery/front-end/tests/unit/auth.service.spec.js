import auth from "../../src/service/auth.service";

describe('auth.service', () => {
  test('test login', async () => {
    const data = await auth.login({
      username: 'test',
      password: 'test'
    });
    await new Promise(r => setTimeout(r, 5000));
    console.log(localStorage.getItem('user'));
  }, 120 * 1000);
});