/**
 * 프록시 객체
 */
const handler = {
    get: function (target, name) {
        return name === 'name' ? `${target.a} ${target.b}` : target[name];
    }
}
const box1 = { a: 'ABC', b: 'HAHAHA' };
const p = new Proxy(box1, handler);
console.log(p.name);

/**
 * 프록시 객체를 이용해 옵저버 패턴 구현
 * 특정 속성에 접근할 때 targer의 동작을 가로채서 정의한 동작을 실행. 
*/
function createReactiveObject(target, callback) {

    const proxy = new Proxy(target, {
        get(target, name) {
            const t = Object.keys(target);
            return name === 'name' ? `${t[0]}` : target[name];
        },
        set(obj, prop, value) {
            if (value !== obj[prop]) {
                const prev = obj[prop];
                obj[prop] = value;
                callback(`${prop}가 [${prev}] ==> [${value}]로 변경되었습니다!`);
            }
            return true;
        }
    });

    return proxy;
}

const box = {
    tomato: 'fresh'
};
const b = createReactiveObject(box, console.log);
b.tomato = 'fresh';
b.tomato = 'not fresh';

console.log(b.name); //tomato
