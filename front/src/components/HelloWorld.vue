<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <ul>
      <li v-for="(item,idx) in list">{{item}}</li>
    </ul>
  </div>
</template>

<script>
  import SockJS from 'sockjs-client'

  export default {
    data() {
      return {
        msg: 'Test WebSocket',
        websocket: {},
        list: []
      }
    },
    mounted() {
      let that = this
      this.$http.get('api/service-websocket/test').then(res => {
        console.log(res)
      })
      if (window['WebSocket']) {
        //原声websocket
        // that.websocket = new WebSocket("ws://localhost:8081/websocket");
        this.websocket = new WebSocket("ws://localhost:8080/api/service-websocket/websocket");
      } else {
        that.websocket = new SockJS("http://localhost:8080/api/service-websocket/websocket/socketjs");
      }
      that.websocket.onopen = function (event) {
        console.log("websocket开启:" + event);
      }
      that.websocket.onclose = function (event) {
        console.log("websocket关闭:" + event);
      };
      that.websocket.onmessage = function (event) {
        console.log(event.data);
        that.list.push(event.data)
      }

    }
  }
</script>
<style scoped>
</style>
