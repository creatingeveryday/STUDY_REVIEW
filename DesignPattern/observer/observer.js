/**
 * 프록시 객체를 이용해 옵저버 패턴 구현
 * 특정 속성에 접근할 때 targer의 동작을 가로채서 정의한 동작을 실행.
 * 
*/

const handler = {
    get: function (target, name) {
        return name === 'name' ? `${target.a} ${target.b}` : target[name];
    }
}

const p = new Proxy({ a: 'ABC', b: 'HAHAHA' }, handler);
console.log(p.name);