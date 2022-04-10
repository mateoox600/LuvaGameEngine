
local Button = {}
Button.__index = Button

function Button:new(x, y, width, height, options)
    local button = {}
    setmetatable(button, Button)
    button.x = x
    button.y = y
    button.width = width
    button.height = height
    button.clicked = false
    button.options = {
        text = '',
        fontSize = 14,
        borderColor = Colors.WHITE,
        backgroundColor = Colors.WHITE,
        textColor = Colors.BLACK,
        lineWidth = 1
    }
    for key, value in pairs(options) do
        button.options[key] = value
    end
    on('mouseButtonPressed', function(key, clickX, clickY)
        if key == MouseButton.MOUSE_BUTTON_LEFT then
            if clickX >= button.x and clickX <= button.x + button.width and
                clickY >= button.y and clickY <= button.y + button.height then
                button.clicked = true
            end
        end
    end)
    return button
end

function Button:draw(drawer)
    local textSize = drawer:measureText(self.options.text, self.options.fontSize)
    drawer:strokeRect(self.x, self.y, self.width, self.height, self.options.lineWidth, self.options.borderColor)
    drawer:fillRect(self.x + self.options.lineWidth,
        self.y + self.options.lineWidth,
        self.width - (self.options.lineWidth * 2),
        self.height - (self.options.lineWidth * 2),
        self.options.backgroundColor)
    drawer:drawText(self.options.text,
        self.x + (self.width / 2) - textSize / 2,
        self.y + (self.height / 2) - (self.options.fontSize / 2),
        self.options.fontSize, self.options.textColor)
end

function Button:update()
    if self.clicked then
        self.clicked = false
        return true
    end
    return false
end

return Button