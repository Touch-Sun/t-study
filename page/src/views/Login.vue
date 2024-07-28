<template>
  <div class="login-container d-flex justify-content-center align-items-center vh-100">
    <div class="login-box bg-light p-4 rounded shadow-lg text-center">
      <img src="@/assets/logo.png" alt="Logo" class="logo mb-3" />
      <h1 class="h3 mb-3 fw-normal">登录</h1>
      <form @submit.prevent="login">
        <div class="form-floating mb-3">
          <input type="text" class="form-control" id="username" v-model="credentials.username" placeholder="用户名" required>
          <label for="username">用户名</label>
        </div>
        <div class="form-floating mb-3">
          <input type="password" class="form-control" id="password" v-model="credentials.password" placeholder="密码" required>
          <label for="password">密码</label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">登录</button>
      </form>
    </div>
  </div>
</template>

<script>
import systemUser from '@/api/systemUser';

export default {
  name: 'Login',
  data() {
    return {
      credentials: {
        username: '',
        password: '',
      },
    };
  },
  methods: {
    async login() {
      try {
        const response = await systemUser.login(this.credentials);
        console.log('Login successful:', response.data);
        // handle successful login (e.g., save token, redirect)
      } catch (error) {
        console.error('Login failed:', error);
      }
    },
  },
};
</script>

<style scoped>
.login-container {
  background: linear-gradient(to right, #7b2ff7, #00c6ff);
  animation: fadeIn 1s ease-in-out;
}

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

.login-box {
  max-width: 400px;
}

.logo {
  width: 100px;
}

button {
  background-color: #7b2ff7;
  background-image: linear-gradient(to right, #7b2ff7, #00c6ff);
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #00c6ff;
  background-image: linear-gradient(to right, #00c6ff, #7b2ff7);
}
</style>
