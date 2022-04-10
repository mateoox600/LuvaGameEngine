
local ProgressBar = {}
ProgressBar.__index = ProgressBar

function ProgressBar:new(x, y, width, height, options)
    local progressBar = {}
    setmetatable(progressBar, ProgressBar)
    progressBar.x = x
    progressBar.y = y
    progressBar.width = width
    progressBar.height = height
    progressBar.progress = 0
    progressBar.options = {
        ['time'] = -1,
        ['horizontal'] = false,
        ['borderColor'] = Colors.WHITE,
        ['progressColor'] = Colors.WHITE,
        ['lineWidth'] = 1
    }
    for key, value in pairs(options) do
        if key == 'progress' then
            progressBar.progress = value
        else
            progressBar.options[key] = value
        end
    end
    return progressBar
end

function ProgressBar:draw(drawer)
    drawer:strokeRect(self.x, self.y, self.width, self.height, self.options.lineWidth, self.options.borderColor)
    if not self.options.horizontal then
        drawer:fillRect(self.x + self.options.lineWidth,
            self.y + self.options.lineWidth,
            self.width - (self.options.lineWidth * 2),
            math.min(math.max(self.height * self.progress - (self.options.lineWidth * 2), 0), self.height - (self.options.lineWidth * 2)),
            self.options.progressColor)
    else
        drawer:fillRect(self.x + self.options.lineWidth,
            self.y + self.options.lineWidth,
            math.min(math.max(self.width * self.progress - (self.options.lineWidth * 2), 0), self.width - (self.options.lineWidth * 2)),
            self.height - (self.options.lineWidth * 2),
            self.options.progressColor)
    end
end

function ProgressBar:update()
    self.progress = self.progress + (getTimeDelta() / self.options.time)
    if self.progress >= 1 then
        self.progress = 0
        return true
    end
    return false
end

return ProgressBar