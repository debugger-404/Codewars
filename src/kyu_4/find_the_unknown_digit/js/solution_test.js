const { assert } = require('chai');

describe('Example tests', () => {
    const testCases = [
        ['1+1=?', 2],
        ['123*45?=5?088', 6],
        ['-5?*-1=5?', 0],
        ['19--45=5?', -1],
        ['??*??=302?', 5],
        ['?*11=??', 2],
        ['??*1=??', 2],
        ['??+??=??', -1]
    ];
    for(const [exp, expected] of testCases)
        it(`exp = ${JSON.stringify(exp)}`, () => {
            assert.strictEqual(solveExpression(exp), expected);
        });
});