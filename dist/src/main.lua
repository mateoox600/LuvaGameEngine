local ProgressBar = require('./src/components/progressBar.lua')
local Button = require('./src/components/button.lua')

local credits = 0
local creditGain = 1

local creditBar = ProgressBar:new(5, 560, 790, 35, {
    ['time'] = 25, ['horizontal'] = true,
    ['borderColor'] = Colors.fromRGB(173, 175, 184),
    ['progressColor'] = Colors.fromRGB(83, 100, 194),
    ['lineWidth'] = 2
})

local speedUpButton = Button:new(345, 520, 110, 35, {
    ['text'] = 'Speed up', ['fontSize'] = 20,
    ['borderColor'] = Colors.RED,
    ['backgroundColor'] = Colors.BLUE,
    ['textColor'] = Colors.WHITE,
    ['lineWidth'] = 2
})

local buyCreditGainButton = Button:new(640, 25, 150, 25, {
    ['text'] = 'Up credit gain by 1',
    ['borderColor'] = Colors.RED,
    ['backgroundColor'] = Colors.BLUE
})

on('draw', function(drawer)
    drawer:drawText('Credits: ' .. tostring(credits), 10, 10, 20, Colors.WHITE)

    speedUpButton:draw(drawer)
    creditBar:draw(drawer)

    local creditGainText = 'Credits gain: ' .. tostring(creditGain)
    drawer:drawText(creditGainText, 400 - (drawer:measureText(creditGainText, 20) / 2), 567, 20, Colors.WHITE)
    
    buyCreditGainButton:draw(drawer)

    local text = 'Cost: ' .. tostring(creditGain * 10)
    local textWidth = drawer:measureText(text, 14)
    drawer:drawText(text, 715 - textWidth / 2, 55, 14, Colors.BLACK)
end)

on('update', function()
    if buyCreditGainButton:update() then
        if credits >= creditGain * 10 then
            credits = credits - creditGain * 10
            creditGain = creditGain + 1
        end
    end

    if speedUpButton:update() then
        creditBar.progress = creditBar.progress + 0.1
    end
    
    if creditBar:update() then
        credits = credits + creditGain
    end
end)